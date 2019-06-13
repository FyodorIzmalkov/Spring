import java.util.*;

public class Operators {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numOfPhones = Integer.parseInt(scanner.nextLine());
        String[] phonesBook = new String[numOfPhones];
        for (int i = 0; i < numOfPhones; i++){
            phonesBook[i] = scanner.nextLine();
        }
        int numOfShablons = Integer.parseInt(scanner.nextLine());
        String[] shablonsBook = new String[numOfShablons];
        for (int i  = 0; i < numOfShablons; i++)
        {
            shablonsBook[i] = scanner.nextLine();
        }
        HashMap<String, String> shablonMap = new HashMap<>();
        for (String str: shablonsBook){
            String key = "";
            String value = "";
            int counter = 0;
            int j = 0;
            int len = str.length();
            for (int i = 0; i < len; i++){
                char ch = str.charAt(i);
                if (ch >= 48 && ch <= 57) {
                    counter++;
                    key += ch;
                }
                else if (ch == '(' || ch == ')')
                    key += ch;
                if (ch == 'X'){
                    key += " ";
                    int k = i;
                    while (str.charAt(k) == 'X'){
                        char c = str.charAt(k);
                        counter++;
                        k++;
                    }
                    key += counter;
                    j = i + 1;
                    while (j < len){
                        char c = str.charAt(j);
                        if (c == '-'){
                            j+=2;
                            break;
                        }
                        j++;
                    }
                    for (int l = j; l < len; l++){
                        char c = str.charAt(l);
                        value += c;
                    }
                    shablonMap.put(key, value);
                    break;
                }
            }
        }
        List<String> phonesList = new ArrayList<>();
        for (String str: phonesBook){
            int len = str.length();
            String value = "";
            for (int i = 0; i < len; i++){
                char ch = str.charAt(i);
                if (ch >= 48 && ch <= 57)
                    value += ch;
            }
            phonesList.add(value);
        }
        for (String str : phonesList){
            int len = str.length();
            for (Map.Entry<String, String> entry : shablonMap.entrySet()) {
                String key = entry.getKey();
                String[] keyArr = key.split(" ");
                boolean flag = false;
                int checkLen = Integer.parseInt(keyArr[1]);
                if (len == checkLen){
                    String numCode = keyArr[0];
                    int m = 0;
                    for (int j = 0; j < numCode.length(); j++)
                    {
                        char c = numCode.charAt(j);
                        if (c >= 48 && c <= 57){
                            if (c == str.charAt(m)){
                                m++;
                                continue;
                            }
                            else{
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (flag)
                        continue;
                    String print = "+";
                    int j = 0;
                    for (j = 0; j < numCode.length(); j++){
                        char ch = numCode.charAt(j);
                        if (ch == '(') {
                            print += " ";
                            print += ch;
                        }
                        else if (ch == ')'){
                            print += ch;
                            print += " ";
                        }
                        else
                            print += ch;
                    }
                    for (int i = numCode.length() -2; i < len; i++){
                        char ch = str.charAt(i);
                            print += ch;
                    }
                    print += " - ";
                    print += shablonMap.get(key);
                    System.out.println(print);
                    break;
                }

            }

        }
    }
}
