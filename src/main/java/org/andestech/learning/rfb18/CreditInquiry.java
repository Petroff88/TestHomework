package org.andestech.learning.rfb18;

import java.sql.SQLException;
import java.util.Scanner;

//этот класс должен обрабатывать заявки на кредит
public class CreditInquiry {

    public void createEnquiry() throws CreditInquiryException, SQLException, ClassNotFoundException {

        Scanner sc1 = new Scanner(System.in);
//        System.out.println("Введите имя клиента");
//        String _name = sc1.next();
//        System.out.println("Введите фамилию клиента");
//        String _sname = sc1.next();
//        System.out.println("Введите запрплату клиента");

        Customer cus1 = new Customer("Иван","Иванов",30000, 56,1);
        System.out.println("Введите суму кредита");
        double _issuedSum = sc1.nextDouble();
        System.out.println("Введите рассрочку в месяцах ");
        int _period = sc1.nextInt();
        double _toPay = _issuedSum * (1+(0.1*(_period/12)));
        double _monthlyPay = _toPay/_period;
        System.out.println("Обработка заявки:");
        System.out.println("Сумма к выдаче: " + _issuedSum + ", сумма к выплате: " + ", ежемесячный платеж: " + _monthlyPay + ", сроком на " + _period +" месяцев.");

        if (cus1.age<18)
        {
            //System.out.println("В выдаче кредита отказано: клиент несовершеннолетний");
            throw new CreditInquiryException("В выдаче кредита отказано: клиент несовершеннолетний");
        }
        else if (cus1.age>99)
        {
            //System.out.println("В выдаче кредита отказано");
            throw new CreditInquiryException("В выдаче кредита отказано");
        }
        else if (cus1.creditRating<0)
        {
            //System.out.println("В выдаче кредита отказано: отрицательная кредитная история");
            throw new CreditInquiryException("В выдаче кредита отказано: отрицательная кредитная история");

        }
        else if (_monthlyPay>cus1.salary-15000) {
            //System.out.println("В выдаче кредита отказано: ежемесячный платеж не должен превышать " + (cus1.salary-15000));
            throw new CreditInquiryException("В выдаче кредита отказано: ежемесячный платеж не должен превышать " + (cus1.salary-15000));
        }
        else {
            System.out.println("Заявка на кредит одобрена");
            System.out.println("Сумма к выдаче: " + _issuedSum + ", сумма к выплате: "+ _toPay + ", ежемесячный платеж: " + _monthlyPay + ", сроком на " + _period +" месяцев.");


            //добавить клиента в бд


            CreditAccount ca1 = new CreditAccount(cus1.id, _toPay, _monthlyPay, _period);
            ca1.setAccNum();
            System.out.println("Номер счета:" + ca1.accNum);

            //добавить счет в бд
        }




    }
}
