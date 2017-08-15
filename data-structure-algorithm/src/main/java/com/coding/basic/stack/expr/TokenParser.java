package com.coding.basic.stack.expr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yrs on 2017/4/18.
 */
public class TokenParser {
    public List<Token> parse(String expr) {
        List<Token> tokens = new ArrayList<>();

        int i = 0;
        while (i < expr.length()) {
            char c = expr.charAt(i);

            if (isOperator(c)) {
                Token token = new Token(Token.OPERATOR, String.valueOf(c));
                tokens.add(token);
                i++;
            }else if (Character.isDigit(c)) {
                int nextIndex = indexOfNextOperator(i, expr);
                Token token = new Token(Token.NUMBER, expr.substring(i, nextIndex));
                tokens.add(token);
                i = nextIndex;
            }else {
                System.out.println("char: [" + c + "] is not number or operator, ignore");
            }
        }
        return tokens;
    }

    private int indexOfNextOperator(int i, String expr) {
        while (Character.isDigit(expr.charAt(i))) {
            i++;
            if (i >= expr.length()) {
                break;
            }
        }
        return i;
    }

    private boolean isOperator(char c) {
        String sc = String.valueOf(c);
        return Token.OPERATORS.contains(sc);
    }
}
                