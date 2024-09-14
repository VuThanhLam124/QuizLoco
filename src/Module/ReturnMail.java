package Module;

 public class ReturnMail {

     public static String returnMail() {
         String code = "";
         for (int i = 0; i < 6; i++) {
             code += (int) (Math.random() * 10);
         }
         return code;
     }
//  test return mail
     public static void main(String[] args) {
         System.out.println(returnMail());
     }
 }

