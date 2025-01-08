// class Room{
//     int length;
//     int width;

//     public Room(){
//         System.out.println("--------------------------");
//     }

//     public Room(String str){
//         this();
//         System.out.println(" Area : ");
//     }

//     public Room(int lenght, int width){
//         this("abc");
//         this.length = lenght;
//         this.width = width;
//         this.area();
//     }

//     public void area(){
//         System.out.println(length * width);
//     }

//     public static void main(String[] args){
//         Room r1 = new Room(10, 20);
//     }
// }

// class Room{
//     int len, width;
//     public Room(int len, int width){
//         this.len = len;
//         this.width = width;
//     }

//     public void area(){
//         System.out.println(len * width);
//     }

//     public static void main(String[] args){
//         Room r1 = new Room(10, 20);
//         Room r2 = new Room(30, 40);

//         r1.area();
//         r2.area();
//         System.out.println("___________________________________________________");

//         r1.len = 50;
//         r2.width = 60;
//         r1.area();
//         r2.area();
//         System.out.println("___________________________________________________");

//         r1 = r2;
//         r1.len = 70;
//         r2.width = 80;
//         r1.area();
//         r2.area();
//         System.out.println("____________________________________________________");
//     }
// }


