import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Users> usersArray = new ArrayList<>();

//    static Users[] usersArray = {new Elector("Ivan Petrov", "Petrov", "Qwerty"),
//            new Elector("Ivan Smirnov", "Smirnov", "Qwerty"),
//            new Elector("Ivan Ivanov", "Ivanov", "Qwerty"),
//            new Admin("Admin", "Admin", "Admin"),
//    };

    static ArrayList<Candidate> candidates = new ArrayList<>();
//    static Candidate[] candidates = {new Candidate("Fire"),
//            new Candidate("Water"),
//            new Candidate("Cold"),
//    };

    static Voting currentVoting = new Voting("Space", candidates);

    public static void main(String[] args) {
        usersArray.add(new Elector("Ivan Petrov", "Petrov", "Qwerty"));
        usersArray.add(new Elector("Ivan Smirnov", "Smirnov", "Qwerty"));
        usersArray.add(new Elector("Ivan Ivanov", "Ivanov", "Qwerty"));
        usersArray.add(new Admin("Admin", "Admin", "Admin"));
        candidates.add(new Candidate("Fire"));
        candidates.add(new Candidate("Water"));
        candidates.add(new Candidate("Ice"));

        int temp = 1;
        while (temp == 1) {
            System.out.println("Добро пожаловать в систему выборов");
            System.out.println("Для выбора действия нажмите его номер");
            System.out.println("1. Регистрация"); // +
            System.out.println("2. Голосование");
            System.out.println("3. Результаты выборов");
            System.out.println("4. Добавить кандидата");
            System.out.println("5. Список пользователей"); // +
            System.out.println("0. Выход");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Введите имя");
                    Scanner scReg = new Scanner(System.in);
                    String name = scReg.nextLine();
                    System.out.println("Введите логин");
                    String login = scReg.nextLine();
                    System.out.println("Введите пароль");
                    String password = scReg.nextLine();
//                    Users userReg = new Elector(name, login, password);
//                    usersArray.add(userReg);
                    addUser(name,login,password);
                    System.out.println("Регистрация завершена");
                    System.out.println("--------------------------------");
                    break;
                case 2:
                    System.out.println("Выборы: " + currentVoting.title);
                    System.out.println("Введите имя пользователя:");
                    Scanner log6 = new Scanner(System.in);
                    String login6 = log6.nextLine();
                    System.out.println("Введите пароль пользователя:");
                    String pass6 = log6.nextLine();
                    int count = 0;
                    for (Users ElUs6 : usersArray) {
                        if (ElUs6.enter(login6,pass6) && ElUs6 instanceof Elector) {
                            System.out.println("Добро пожаловать в голосование " + ElUs6.getName());
                            if (!((Elector) ElUs6).isVoted())
                            {
                                    System.out.println("Список кандидатов:");
                                    for (Candidate ElCan6 : candidates) {
                                    System.out.println("Кандидат: " + ElCan6.getName());
                                }
                                System.out.println("--------------------------------");
                                System.out.println("Ваше голосование:");
                                for (Candidate ElCan6 : candidates) {
                                    System.out.println("Кандидат:" + ElCan6.getName() + ". Поставьте 0 или 1");
                                    Scanner sc6 = new Scanner(System.in);
                                    int count6 = sc6.nextInt();
                                    if (count6 == 1)
                                        ElCan6.addVoice();
                                }
                                ((Elector) ElUs6).vote();
                                System.out.println("--------------------------------");
                            }
                            else
                            {
                                System.out.println("Вы не можете голосовать повторно");
                                System.out.println("--------------------------------");
                            }
                        }
                        else {
                            count++;
                        }
                        if (count == usersArray.size())
                            System.out.println("Доступ запрещен. Логин или пароль неправильные. Попробуйте еще раз.");
                    }
                    break;
                case 3:
                    System.out.println("Для просмотра итогов голосования необходим доступ администратора");
                    System.out.println("Введите логин администратора:");
                    Scanner log = new Scanner(System.in);
                    String login7 = log.nextLine();
                    System.out.println("Введите пароль администратора:");
                    String pass7 = log.nextLine();
                    count = 0;
                    for (Users ElUs : usersArray) {
                        if (ElUs.enter(login7,pass7) && ElUs instanceof Admin) {
                            for (Candidate ElCan : candidates) {
                                System.out.println("Кандидат: " + ElCan.getName() + ". Рейтинг: " + ElCan.getVoices());
                            }
                            getResult(candidates);
                            System.out.println("--------------------------------");
                            break;
                        }
                        else {
                            count++;
                        }
                        if (count == usersArray.size())
                            System.out.println("Доступ запрещен. Логин или пароль неправильные. Попробуйте еще раз.");
                    }
                    break;
                case 4:
                    System.out.println("Для добавления кандидата необходим доступ администратора");
                    System.out.println("Введите логин администратора:");
                    Scanner log4 = new Scanner(System.in);
                    String login4 = log4.nextLine();
                    System.out.println("Введите пароль администратора:");
                    String pass4 = log4.nextLine();
                    count = 0;
                    for (Users ElUs : usersArray) {
                        if (ElUs.enter(login4, pass4) && ElUs instanceof Admin) {
                            System.out.println("Введите имя кандидата:");
                            Scanner candid = new Scanner(System.in);
                            String cand4 = candid.nextLine();
                            //Candidate candidate4 = new Candidate(cand4);
                            candidatUser(cand4);
                            //candidates.add(candidate4);
                            break;
                        }
                        else {
                            count++;
                        }
                        if (count == usersArray.size())
                            System.out.println("Доступ запрещен. Логин или пароль неправильные. Попробуйте еще раз.");
                    }
                    System.out.println("--------------------------------");
                    break;
                case 5:
                        System.out.println("Для просмотра списка пользователей необходим доступ администратора");
                        System.out.println("Введите логин администратора:");
                        Scanner log9 = new Scanner(System.in);
                        String login9 = log9.nextLine();
                        System.out.println("Введите пароль администратора:");
                        String pass9 = log9.nextLine();
                        count = 0;
                        for (Users ElUs : usersArray) {
                            if (ElUs.enter(login9, pass9) && ElUs instanceof Admin) {
                                for (Users ElUser : usersArray) {
                                    if (ElUser instanceof Elector) {
                                        System.out.println("Имя: " + ElUser.name + ". Логин: " + ElUser.login + ". Пароль: " + ElUser.password);
                                    }
                                }
                                break;
                            } else {
                                count++;
                            }
                        }
                            if (count == usersArray.size())
                                System.out.println("Доступ запрещен. Логин или пароль неправильные. Попробуйте еще раз.");

                            //System.out.println("Доступ запрещен");
                    System.out.println("--------------------------------");
                            break;
                case 0:
                    temp = 0;
                    break;
                default:
                    System.out.println("Неправильный выбор. Попробуйте еще раз.");
            }
        }
    }

//    public Users findUser(String login, String password) {
//        for (Users ElUs6 : usersArray) {
//            if (ElUs6.enter(login, password))
//                return ElUs6;
//            else
//                return new Elector("*", "*", "*");
//        }
//    }


    public static void addUser(String name, String login, String password) {
        Users userReg = new Elector(name, login, password);
        usersArray.add(userReg);
    }

    public static void candidatUser(String name) {
        Candidate userReg = new Candidate(name);
        candidates.add(userReg);
    }

    public static void getResult(ArrayList<Candidate> candidates) {
        System.out.println("Победил:" );
        int win = 0;
        for (int i = 1; i < candidates.size(); i++)
        {
            if (candidates.get(win).getVoices() <= candidates.get(i).getVoices())
                win = i;
        }
        for (int i = 0; i < candidates.size(); i++)
        {
            if (candidates.get(win).getVoices() == candidates.get(i).getVoices())
                System.out.println("Кандидат: " + candidates.get(i).getName() + " с результатом: " + candidates.get(i).getVoices());
        }
    }
}





