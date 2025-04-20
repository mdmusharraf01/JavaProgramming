import java.util.*;

class User {
    protected String name;
    protected String userId;
    protected String password;

    public User(String name, String userID, String password){
        this.name = name;
        this.userId = userID;
        this.password = password;
    }

    public boolean authenticate(String enteredPassword){
        return this.password.equals(enteredPassword);
    }
}

// Customer class
class Customer extends User {
    private double balance;

    public Customer(String name, String userID, String password, double balance){
        super(name, userID, password);
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited " + amount + " successfully");
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn " + amount + " successfully");
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount");
        }
    }

    public void checkBalance(){
        System.out.println("Current balance: " + balance);
    }
}

// Employee class
class Employee extends User {
    private String position;

    public Employee(String name, String userID, String password, String position){
        super(name, userID, password);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void viewCustomerDetails(Customer customer){
        System.out.println("Customer name: " + customer.name);
        customer.checkBalance();
    }
}

// Admin class
class Admin extends User {
    public Admin(String name, String userID, String password){
        super(name, userID, password);
    }

    public void viewAllUsers(List<User> users){
        System.out.println("--- Bank Users ---");
        for(User user : users){
            System.out.println("User ID: " + user.userId + ", Name: " + user.name );
        }
    }
}

// Main class
public class project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        // Creating admin and customers
        Admin admin = new Admin("Admin" , "admin01" , "admin123");
        users.add(admin);

        Customer customer1 = new Customer("Ali" , "ali" , "123", 5000);
        users.add(customer1);

        Employee employee1 = new Employee("Bob", "emp01", "emp123", "Manager");
        users.add(employee1);
        
        while(true){
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Customer Login");
            System.out.println("2. Employee Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){
                System.out.print("Enter Customer ID: ");
                String userID = sc.nextLine();
                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                Customer loggedInCustomer = null;
                for(User user : users){
                    if(user instanceof Customer && user.userId.equals(userID) && user.authenticate(password)){
                        loggedInCustomer = (Customer) user;
                        break;
                    }
                }

                if(loggedInCustomer != null){
                    System.out.println("Login successful! Welcome, " + loggedInCustomer.name);
                    while(true){
                        System.out.println("\n1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Check Balance");
                        System.out.println("4. Logout");
                        System.out.print("Enter your choice: ");
                        int custChoice = sc.nextInt();

                        if(custChoice == 1){
                            System.out.print("Enter Deposit Amount: ");
                            double amount = sc.nextDouble();
                            loggedInCustomer.deposit(amount);
                        } else if(custChoice == 2){
                            System.out.print("Enter Withdrawal amount: ");
                            double amount = sc.nextDouble();
                            loggedInCustomer.withdraw(amount);
                        } else if(custChoice == 3){
                            loggedInCustomer.checkBalance();
                        } else {
                            System.out.println("Logging out....");
                            break;
                        }
                    }
                } else {
                    System.out.println("Invalid credentials!");
                }
            }
            else if(choice == 2){
                System.out.print("Enter Employee ID: ");
                String userID = sc.nextLine();
                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                Employee loggedInEmployee = null;
                for(User user : users){
                    if(user instanceof Employee && user.userId.equals(userID) && user.authenticate(password)){
                        loggedInEmployee = (Employee)user;
                        break;
                    }
                }

                if(loggedInEmployee != null){
                    System.out.println("Login successful! Welcome, " + loggedInEmployee.name);
                    System.out.println("Employee Role: " + loggedInEmployee.getPosition());
                } else {
                    System.out.println("Invalid credentials!");
                }
            }
            else if(choice == 3){
                System.out.print("Enter Admin ID: ");
                String userId = sc.nextLine();
                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                if(admin.userId.equals(userId)&& admin.authenticate(password)){
                    System.out.println("Login successful! Welcome, Admin.");
                    admin.viewAllUsers(users);
                } else {
                    System.out.println("Invalid credentials!");
                }
            }
            else if(choice == 4){
                System.out.println("Exiting...");
                break;
            }
        }
        sc.close();
    }
}