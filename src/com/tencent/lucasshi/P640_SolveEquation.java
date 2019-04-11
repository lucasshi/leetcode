package com.tencent.lucasshi;

import java.util.ArrayList;

public class P640_SolveEquation {
    class Expression {
        int variable;
        int constant;

        public Expression(int _var, int _const) {
            this.variable = _var;
            this.constant = _const;
        }
    }

    public int solveEquation(String equation) {
        String[] expressions = equation.split("=");
        Expression e1 = evalEquation(expressions[0]);
        Expression e2 = evalEquation(expressions[1]);
        // do
        return (e2.constant - e1.constant) / (e1.variable - e2.variable);
    }

    public Expression evalEquation(String equation) {
        int multiply = 1;
        String token = "";
        ArrayList<Integer> variables = new ArrayList<>();
        ArrayList<Integer> constatnts = new ArrayList<>();
        int variable = 0;
        int constatnt = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) != '-' || equation.charAt(i) != '+') {
                token += equation.charAt(i);
            } else {
                if (token.charAt(token.length() - 1) == 'x') {
                    int var = Integer.parseInt(token.substring(0, token.length() - 1));
                    variables.add(multiply * var);
                    variable += multiply * var;
                } else {
                    int cs = Integer.parseInt(token);
                    constatnts.add(multiply * cs);
                    constatnt += cs * multiply;
                }
                multiply = equation.charAt(i) == '+' ? 1 : -1;
            }
        }
        return new Expression(variable, constatnt);
    }
}
