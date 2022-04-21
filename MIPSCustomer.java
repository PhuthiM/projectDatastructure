
import java.util.Scanner;

public class MIPSCustomer {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MIPSstore mipsS = new MIPSstore();

        int countQ = 0;
        QueueCustomer queueMan = new QueueCustomer();
        QueueCustomer queueWoman = new QueueCustomer();

        StackShoe[] stackShoe = new StackShoe[11];

        for (int i = 1; i <= 10; i++) {
            stackShoe[i] = new StackShoe();
            String name1 = "AP-" + i;
            stackShoe[i].push(name1);
        }
        System.out.println(" ---------------------------------");
        System.out.println("|      Welcome to MISP Store      |");

        try {
            for (;;) {
                System.out.println("-----------------------------------");
                System.out.println("|        Choose 0 for stop        |");
                System.out.println("|        Choose 1 for start       |");
                System.out.println("-----------------------------------");
                System.out.print("Choose order : ");
                int order = sc.nextInt();
                if (queueMan.isFullQueue() == false || queueWoman.isFullQueue() == false) {
                    System.out.println("Close reservation");
                    break;
                } else if (order != 1 && order != 0) {
                    System.out.println("Choose Again !");
                    continue;
                } else if (order == 0 || countQ > 100) {
                    System.out.println("--------------STOP-----------------");
                    break;
                } else {
                    System.out.println("*** Customer Detail ***");
                    System.out.print("Name : ");
                    String name = sc.next();//ชื่อ
                    System.out.print("Gender (man/woman) : ");
                    String gender = sc.next();//เพศ

                    if (gender.equalsIgnoreCase("man")) { //ถ้าเป็นผู้ชาย
                        System.out.print("Age : ");//อายุ
                        int age = sc.nextInt();
                        System.out.print("TypeSize(eu/cm) : ");
                        String typesize = sc.next();//เลือกชนิดไซส์
                        System.out.print("Size : ");
                        int size = sc.nextInt(); //ขนาดไซส์รองเท้า
                        int sizeMIPS = mipsS.sizeMIPS(typesize, size, 1);

                        if (sizeMIPS == -1) { //ถ้าเลือกไซส์หรือขนาดไซส์ผิด วน loop ใหม่
                            System.out.println(" - Cancel Order - ");
                            continue;
                        } else if (stackShoe[sizeMIPS].isEmptyStack()) {
                            System.out.println("Out of Stocks");

                        } else {
                            Customer cus = new Customer(name, gender, age, typesize, size);// เก็บข้อมูลใน คลาส
                            queueMan.enQueue(cus); //เพิ่มคิว
                            countQ++;
                            System.out.println("---- Result -------");
                            System.out.println("Success reserve No." + countQ); //การจองสำเร็จ บอก
                            mipsS = new MIPSstore(cus); //นำข้อมูลคลาสไปเก็บใน MIPSstore
                            System.out.print("Name : ");
                            System.out.println(stackShoe[sizeMIPS].pop());
                            System.out.print("Inventories = ");
                            System.out.println(stackShoe[sizeMIPS].getSize());
                            if (stackShoe[sizeMIPS].getSize() == 0) {
                                System.out.println("Out of Stocks");

                            }
                        }
                    } else if (gender.equalsIgnoreCase("woman")) { //ถ้าเป็นผู้หญิง
                        System.out.print("Age : ");//อายุ
                        int age = sc.nextInt();
                        System.out.print("TypeSize(eu/cm) : ");
                        String typesize = sc.next();//เลือกชนิดไซส์
                        System.out.print("Size : ");
                        int size = sc.nextInt(); //ขนาดไซส์รองเท้า
                        int sizeMIPS = mipsS.sizeMIPS(typesize, size, 2);

                        if (sizeMIPS == -1) { //ถ้าเลือกไซส์หรือขนาดไซส์ผิด วน loop ใหม่
                            System.out.println("Cancel Order");
                            continue;
                        }
                        if (stackShoe[sizeMIPS].isEmptyStack()) {
                            System.out.println("Out of Stocks");
                        } else {
                            Customer cus = new Customer(name, gender, age, typesize, size);// เก็บข้อมูลใน คลาส
                            queueMan.enQueue(cus); //เพิ่มคิว
                            countQ++;
                            System.out.println("------ Result -------");
                            System.out.println("Success reserve No." + countQ); //การจองสำเร็จ บอก
                            mipsS = new MIPSstore(cus); //นำข้อมูลคลาสไปเก็บใน MIPSstore
                            System.out.print("Name : ");
                            System.out.println(stackShoe[sizeMIPS].pop());
                            System.out.print("Inventories = ");
                            System.out.println(stackShoe[sizeMIPS].getSize());
                            if (stackShoe[sizeMIPS].getSize() == 0) {
                                System.out.println("Out of Stocks");
                            }
                        }
                    } else {
                        System.out.println("Wrong Information!!!");
                        continue;
                    }
                    boolean outofstock = true;
                    for (int m = 1; m <= 10; m++) {
                        if (stackShoe[m].getSize() != 0) {
                            outofstock = false;
                        }
                    }
                    if (outofstock) {
                        System.out.println("All products are sold out");
                        System.out.println("-------------------------");
                        break;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Wrong Information!!!");
        }

    }
}
