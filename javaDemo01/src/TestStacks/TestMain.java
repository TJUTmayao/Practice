package TestStacks;

import java.util.Scanner;

/**
 * 说明：计算器（不包含括号）
 *
 * @Auther: 11432_000
 * @Date: 2018/10/21 13:39
 * @Description:
 */
public class TestMain {

    private static String[] operators = {"+","-","*","/","(",")"};

    public static void main(String[] arg){
        ArraysStacks number = new ArraysStacks(100);
        ArraysStacks operator = new ArraysStacks(100);
        pushCalculationFormula(number ,operator);
    }

    public static void pushCalculationFormula(ArraysStacks numberStack ,ArraysStacks operatorStack){
        Scanner sc = new Scanner(System.in);
        String calculationFormula = sc.next();
        int index = 10000;
        while (index >= 0){
            index = 10000;
            for (String oper : operators){
                int indexOf = calculationFormula.indexOf(oper);
                if (indexOf >= 0 && indexOf < index){
                    index = indexOf;
                }
            }
            if (index == 10000){
                numberStack.push(calculationFormula);
                while (operatorStack.getTop() != 0){
                    numberStack.push(operation(numberStack ,operatorStack.out()));
                }
                break;
            }
            String operator = String.valueOf(calculationFormula.charAt(index));
            String number = null;
            if (!"(".equals(operator) && !")".equals(operator)){
                number = calculationFormula.substring(0, index);
                calculationFormula = calculationFormula.substring(index);
            }
            calculationFormula = calculationFormula.substring(1);
            System.out.println(operator +  "    " + number );
            if (number != null && !number.isEmpty()){
                numberStack.push(number);
            }
            while (logic(numberStack ,operatorStack ,operator)){}
            if (!")".equals(operator)){
                operatorStack.push(operator);
            }
        }
        System.out.println(numberStack.out());
    }

    public static boolean checkPriority(String s1 ,String s2){
        if ("(".equals(s1)){
            return false;
        }
        if (")".equals(s1)){
            return true;
        }
        if (s1.matches("[+,-]")){
            return true;
        }
        else if (s1.matches("[*,/]") && s2.matches("[+,-]")){
            return false;
        }
        else if (s1.matches("[*,/]") && s2.matches("[*,/]")){
            return true;
        }
        return false;
    }

    public static String operation(ArraysStacks numbers , String oper){
        /* 左边的数 */
        double num1 = Double.valueOf(numbers.out());
        /* 右边的数 */
        double num2 = Double.valueOf(numbers.out());
        String result = null;
        Double sum = 0.0;
        switch (oper){
            case "+":
                sum = num2 + num1;
                break;
            case "-":
                sum = num2 - num1;
                break;
            case "*":
                sum = num2 * num1;
                break;
            case "/":
                sum = num2 / num1;
                break;
        }
        return String.valueOf(sum);
    }

    public static boolean logic(ArraysStacks numbers ,ArraysStacks operators ,String nowOper){
        if (operators.getTop() == 0){return false;}
        if (operators.getTop() != 0){
            String out = operators.out();
            if ("(".equals(nowOper) && ")".equals(out)){
                return false;
            }
            if (checkPriority(nowOper ,out)){
                String operation = operation(numbers, out);
                numbers.push(operation);
                return true;
            }
            if (!checkPriority(nowOper ,out)){
                operators.push(out);
                return false;
            }
        }
        return false;
    }


}


