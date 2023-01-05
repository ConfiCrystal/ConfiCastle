//Sep 28 2021
//(THIS IS CHERRY'S CLASS)
public class FurryMammal{

   //attributes
   private String name;
   private String breed;
   private String colour;
   private String favActivity;
   private double weight;
   private int age; 

   
   //constructor
   //default constructor
   public FurryMammal()
   {
      this.name = "furry mammal";
      this.breed = "N/A";
      this.colour = "none";
      this.favActivity = "None";
      this.weight = 0;
      this.age = 0;
      
   }
   
   //constructor
   //General constructor
   public FurryMammal(String name, String breed, String colour, String favActivity, double weight, int age)
   {
      this.name = name;         
      this.breed = breed;      
      this.colour = colour;
      this.favActivity = favActivity;
      this.weight= weight;
      this.age= age;
   }
   
   
   /****
   Methods
   ****/
   //getName
   public String getName(){
      return this.name;
   }
   
   //getBreed
   public String getBreed(){
      return this.breed;
   }
   
   //getColour
   public String getColour(){
      return this.colour;
   }
   
   //getFavActivity
   public String getFavActivity () {
      return this.favActivity;
   }   
    
   //getWeight
   public double getWeight (){
      return this.weight;
   }
    
   public int getAge() {
      return this.age;
   }
     
   /**set**/
   //setName
   public void setName (String newName)             
   {
      newName = newName.substring(0,1).toUpperCase() + newName.substring(1).toLowerCase();
      this.name = newName;        
   } 
   
   //setFavActivity
   public void setFavActivity (String newFavActivity)
   {  
      this.favActivity = newFavActivity;
   }
   
   
   //setWeight
   public void setWeight (double newWeight)
   {
      if(newWeight >= 0)
      {
         this.weight =  newWeight;
      } 

   }
   
   //setAge
   public void setAge (int newAge)
   {
      if(age >= 0 && age < 100)
         {
            this.age =  newAge;
         }
   }

   //method for sleep
   public void sleep (int time){
      System.out.println(this.name + " sleeps for " + time + " hours.");
   }
   
   //method for groom
   public void groom () {
      System.out.print (this.name + " is grooming its " + this.colour + " fur");
   }
   
   public void play (int hourPlaying) {
   
      System.out.print(this.name + " is doing " + this.favActivity);
      System.out.println(" ,and " + this.name + " lost " + 0.02 * hourPlaying + "kg");
      this.weight -= 0.02; 
   }
   
   public String toString() {
      String ret = "Name: " + this.name + 
                  "/n Breed: " + this.breed + 
                  "/n Age: " + this.age;
      return ret;
 
    } 
    
    public void eat (Meat food)
   {
      this.weight = this.weight + (food.weight()  - food.boneWeight());
      food.eaten();
   }
    
   public void eat (Vegetable veggie)
   {
      this.weight = this.weight + veggie.weight();
      veggie.eaten();
   }
    
   public void eat (Meat food, double biteSize){  //eat method same name can be used in different place with diff parameter
                                                   //when you want generally the same function
      double meatWeight = food.weight() - food.boneWeight();
      if(biteSize <meatWeight){
         this.weight = this.weight + biteSize;
         food.eaten(biteSize);
      }
      else{
         this.weight = this.weight  + meatWeight; //add only the meat weight
         food.eaten();  //eaten completely
      }
   }
    
   public void eat (Vegetable veggie, double biteSize){  //eat method same name can be used in different place with diff parameter
                                                   //when you want generally the same function
      double vegWeight = veggie.weight();
      if(biteSize <vegWeight){
         this.weight = this.weight + biteSize;
         veggie.eaten(biteSize);
      }
      else{
         this.weight = this.weight  + vegWeight; //add only the meat weight
         veggie.eaten();  //eaten completely
      }
       
   }
  


}
