package com.fustack.compile;

/**
 * Created by yaoagcn on 2019/12/17.
 */
public enum DfaState {

    Initial,
    Id,
    IntLiteral,
    GT,        // >
    GE,         // >=
    EQ,       // =
    EQ_Ex,      // ==
    Identifier,
    Plus,       // +
    Minus,      // -
    Star,       // *
    Slash       // /

}
