import java.util.Scanner;

public class test01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int count = 0;

        for(int i = 0; i<chars.length; i++){
            switch(chars[i]){
                case 'c':
                    if((i+1)<chars.length && (chars[i+1] == '=' || chars[i+1] == '-')){
                        count++;
                        i++;
                        break;
                    }else {count++;
                        break;}
                case 'd':
                    if((i+1)<chars.length && (i+2)<chars.length &&
                            (chars[i+1] == 'z' && chars[i+2] == '=')){
                        count++;
                        i += 2;
                        break;
                    }else if((i+1)<chars.length && chars[i+1] == '-'){
                        count++;
                        i++;
                        break;
                    }else {count++;
                        break;}
                case 'l':
                    if((i+1)<chars.length && chars[i+1] == 'j'){
                        count++;
                        i++;
                        break;
                    }else {count++;
                        break;}
                case 'n':
                    if((i+1)<chars.length && chars[i+1] == 'j'){
                        i++;
                        count++;
                        break;
                    }else {count++;
                        break;}
                case 's':
                    if((i+1)<chars.length && chars[i+1] == '='){
                        i++;
                        count++;
                        break;
                    }else {count++; break;}
                case 'z':
                    if((i+1)<chars.length && chars[i+1] == '='){
                        i++;
                        count++;
                        break;
                    }else{count++; break;}
                default: count++; break;
            }
        }
        System.out.println(count);

    }
}
