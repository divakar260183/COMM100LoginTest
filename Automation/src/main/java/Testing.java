
public class Testing {
    public interface Operation {
        void getResult();
    }
    public static class Table {
        int number;
        public Table(int number) {
            this.number = number;
        }
    }
    public static class Generate_Table extends Table implements Operation {
        public Generate_Table(int number) {
            super(number);
        }
        public void getResult() {
            System.out.println("The table is: ");
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " * " + i + " = "
                        + number * i);
            }
        }
    }

    public static void main(String[] args) {
        Generate_Table table = new Generate_Table(5);
        table.getResult();
        Operation opr = new Generate_Table(6);
        opr.getResult();

    }
}
