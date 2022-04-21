

public class MIPSstore {

    String name;
    String gender;
    int age;
    int size;
    String typesize;
    Customer customer;
    public MIPSstore() {

    }

    public MIPSstore(String name, String gender, int age, String typesize, int size) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.size = size;
        this.typesize = typesize;
    }

    public MIPSstore(Customer customer) {
        this.customer = customer;

    }

    int sizeMIPS(String typesize, int size, int gen) throws Exception {
        boolean check = false;
        if (gen == 1) {
            for (int i = 1; i <= 5; i++) {
                if (typesize.equalsIgnoreCase("EU") && size - i == 37 || typesize.equalsIgnoreCase("CM") && size - i == 23) {
                    check = true;
                    return i;
                }
            }
        } else {
            for (int i = 6; i <= 10; i++) {
                if (typesize.equalsIgnoreCase("EU") && size - 30 == i || typesize.equalsIgnoreCase("CM") && size - 16 == i) {
                    check = true;
                    return i;
                }
            }
        }
        if (check == false) {
            System.out.println(" -- No Product -- ");
        }
        return -1;
    }
    
    
    
}
