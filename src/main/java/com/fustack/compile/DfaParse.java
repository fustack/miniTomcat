package com.fustack.compile;

import com.fustack.util.StrUitl;

/**
 * Created by yaoagcn on 2019/12/17.
 */
public class DfaParse {

    public static void main(String[] args) {
        String s = "int a >= 123;";
        parse(s);
        s = "2+3*5";
        parse(s);
    }

    static String tokenText = "";

    public static void parse(final String s) {

        if (StrUitl.isBlank(s)) {

            return;
        }

        DfaState state = DfaState.Initial;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            System.out.println();
            switch (state) {
                case Initial:
                    state = initToken(ch);
                    //tokenText = "";
                    break;
                case Id:
                   if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                       tokenText += ch;
                   } else {
                       System.out.println("id:" + tokenText);
                       state = initToken(ch);
                   }
                    break;
                case GT:
                    if (ch == '=') {
                        state = DfaState.GE;
                        tokenText += ch;
                        System.out.println("ge:" + tokenText);
                    } else {
                        System.out.println("gt:" + tokenText);
                        initToken(ch);
                    }
                    break;
                case GE:
                    state = initToken(ch);
                    break;
                case EQ:
                    if (ch == '=') {
                        tokenText += ch;
                        state = DfaState.EQ_Ex;
                        System.out.println("eq ex:" + tokenText);
                    } else {
                        System.out.println("eq:" + tokenText);
                        state = initToken(ch);
                    }
                    break;
                case EQ_Ex:
                    System.out.println("eq ex:" + tokenText);
                    state = initToken(ch);
                    break;
                case Plus:
                    System.out.println("plus:" + tokenText);
                    state = initToken(ch);
                    break;
                case Minus:
                    System.out.println("minus:" + tokenText);
                    state = initToken(ch);
                    break;
                case Star:
                    System.out.println("star:" + tokenText);
                    state = initToken(ch);
                    break;
                case Slash:
                    System.out.println("slash:" + tokenText);
                    state = initToken(ch);
                    break;
                case IntLiteral:
                    if (Character.isDigit(ch)) {
                        tokenText += ch;
                    } else {
                        System.out.println("intLiteral:" + tokenText);
                        state = initToken(ch);
                    }
                    break;
            }
        }
    }

    public static DfaState initToken(char c) {
        tokenText += c;
        if (Character.isDigit(c)) {
            return DfaState.IntLiteral;
        } else if(c == '>') {
            return DfaState.GT;
        } else if(c == '+') {
            return DfaState.Plus;
        } else if(c == '-') {
            return DfaState.Minus;
        } else if(c == '*') {
            return DfaState.Star;
        } else if(c == '/') {
            return DfaState.Slash;
        } else if (c == '=') {
            return DfaState.EQ;
        } else if (Character.isAlphabetic(c)) {
            return DfaState.Id;
        }
        tokenText = "";
        return DfaState.Initial;

    }
}
