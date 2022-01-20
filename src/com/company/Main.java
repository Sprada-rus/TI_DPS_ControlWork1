package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double x = 0, y = 0;
        boolean running = true;

        System.out.println("Контрольная работа №1 \nВариант №3\n");
        System.out.println("Разработано в системе IntelliJ " +
                "\nПрограмма для решения геометрической задачи.\n" +
                "Вариант №3. Сапронов И.А. СПБ ГТИ(ТУ), 2022 год.\n");

        //Цикл с выполнение расчета
        while (running){
            //Проверка заполнения пользователем переменной X
            try {
                System.out.print("Введите координату X: ");
                x = new Scanner(System.in).nextDouble();
            } catch (Exception e){
                System.out.println("Введены некорректные данны для координата Х!");
                continue;
            }

            //Проверка заполнения пользователем переменной Y
            try{
                System.out.print("Введите координату Y: ");
                y = new Scanner(System.in).nextDouble();
            } catch (Exception e){
                System.out.println("Введены некорректные данны для координата Y!");
                continue;
            }

            //Вывод полеченного расчета
            System.out.println("Точка с координатами (" + x + ", " + y + ")" +
                    " Находится в области: " + checkArea(x, y));

            //Цикл предназначен для проверки ответа пользователя
            while (true){
                System.out.println("Хотите заврешить работу? [y/n]");
                String result = new Scanner(System.in).next().toLowerCase();

                if (result.equals("y") || result.equals("у")){
                    running = false;
                    break;
                } else if (result.equals("n") || result.equals("н")){
                    break;
                }else{
                    System.out.println("Введен некорректный ответ");
                }
            }

        }
    }

    /*
    * Проверка расположения точки внутри или снауржи параболы
    * */
    public static boolean inParabola(double x, double y){
        return (4 * x - 0.5 * Math.pow(x, 2.0)) >= y;
    }

    /*
    * Проверка расположения точки в нижней или верхней полуплоскости
    * */
    public static boolean inLine1(double x, double y){
        return (4 - 0.5 * x) <= y;
    }

    /*
    * Проверка расположения точки слева или справа от линиии x = 6
    * */
    public static boolean inLine2(double x, double y){
        return x <= 6;
    }

    /*
    * Проверка в какой области находится указанная точка
    * */
    public static int checkArea(double x, double y){
        boolean inParabola = inParabola(x, y);
        boolean inLine1 = inLine1(x, y);
        boolean inLine2 = inLine2(x, y);
        int result = 0;

        if (inParabola && inLine1 && inLine2) result = 1;
        if (inParabola && !inLine1 && inLine2) result = 2;
        if (inParabola && inLine1 && !inLine2) result = 3;
        if (inParabola && !inLine1 && !inLine2) result = 4;
        if (!inParabola && inLine1 && inLine2) result = 5;
        if (!inParabola && !inLine1 && inLine2) result = 6;
        if (!inParabola && inLine1 && !inLine2) result = 7;
        if (!inParabola && !inLine1 && !inLine2) result = 8;

        return result;
    }
}