/* Harry Lloyd
	 	C1931340	*/
		import java.util.*;
		public class MagicSquareGame{

		  public static void main(String args[]){
		    int num = 0;
		    int row = 0;
		    int newrow;
		    int newcol;
		    int gamerow;
		    int gamecol;
		    int temp;
		    int temp2;
		    int turns = 0;
		    int exact;
		    String direction = "";
		    String userin = "";
		    boolean equals = false;
		    Scanner read = new Scanner(System.in);
		    Random shuffle = new Random();
				boolean isValid = false;
		    try{
		        System.out.println("Please enter an odd number: ");
		        num = read.nextInt();
		      while(num%2 == 0){
		         num=0;
		         System.out.println("That is not a valid entry, please enter an odd number: ");
		         num = read.nextInt();
		      }
		    }
		    catch(Exception e){
					do{
		        if(read.hasNextInt()){
		          num = read.nextInt();
		          if(num % 2 == 0){
		            System.out.println("Please enter an odd number: ");
		          }
		          else {
		            isValid = true;
		          }
		        }
		        else{
		          System.out.println("Please enter an odd number: ");
		          read.next();
		        }
		      } while(!(isValid));
		    }

		    int col = ((num) / (2));
		    int insert = 1;
		    int[][] square = new int[num][num];
		    while(insert <= num * num){
		      square[row][col]= insert;
		      insert++;
		      newrow = row;
		      newcol = col;
		      row-=1;
		      col+=1;
		      if(row == -1){
		        row = num -1;
		      }
		      if(col == num){
		        col =0;
		      }
		      if (square[row][col] != 0) {
		            row = newrow + 1;
		            col = newcol;
		            if (row == -1) {
		                row = num - 1;
		            }
		        }
		    }
		    System.out.println();
		    int[][] shuffsquare = new int[num][num];
		    for(int h = 0; h < square.length; h++){
		      for(int l = 0; l < square.length; l++){
		        shuffsquare[h][l] = square[h][l];
		      }
		    }
		    for(int s = 0; s < num*num; s++){
		      int randrow = shuffle.nextInt(num);
		      int randcol = shuffle.nextInt(num);
		      temp = shuffsquare[randrow][randcol];
		      if(randrow == 2 && randcol == 2){
		        temp2 = shuffsquare[(randrow - 1)][(randcol -1)];
		        shuffsquare[randrow][randcol] = temp2;
		        shuffsquare[(randrow - 1)][(randcol - 1)] = temp;
		      }
		      if(randrow != 2 && randcol != 2){
		        temp2 = shuffsquare[(randrow + 1)][(randcol + 1)];
		        shuffsquare[randrow][randcol] = temp2;
		        shuffsquare[(randrow + 1)][(randcol + 1)] = temp;
		      }
		      if(randrow != 2 && randcol == 2){
		        temp2 = shuffsquare[(randrow + 1)][(randcol -1)];
		        shuffsquare[randrow][randcol] = temp2;
		        shuffsquare[(randrow + 1)][(randcol - 1)] = temp;
		      }
		      if(randrow == 2 && randcol != 2){
		        temp2 = shuffsquare[(randrow - 1)][(randcol +1)];
		        shuffsquare[randrow][randcol] = temp2;
		        shuffsquare[(randrow - 1)][(randcol + 1)] = temp;
		      }

		    }
		    while(equals == false){
		      turns++;
		      System.out.println("Here is the magic square for " + num + ": ");

		      for(int o = 0; o < square.length; o++){
		        for(int j = 0; j < square.length; j++){
		           System.out.print(square[o][j] + "|");
		        }
		        System.out.println();
		      }
		      System.out.println();
		      System.out.println("Here is the shuffled magic square for " + num + ":");

		      for(int o = 0; o < shuffsquare.length; o++){
		        for(int j = 0; j < shuffsquare.length; j++){
		           System.out.print(shuffsquare[o][j] + "|");
		        }
		        System.out.println();
		      }
		      System.out.println();
		      try{
		        System.out.println("How would you like to modify it?");
		        userin = read.next();
		      }
		      catch(Exception e){
		        System.out.println();
		      }
		      String[] partsuserin = userin.split("");
		      gamerow = Integer.parseInt(partsuserin[0]);
		      gamecol = Integer.parseInt(partsuserin[1]);
		      direction = partsuserin[2].toUpperCase();

		      if(direction.equals("D")){
		        try{
		          temp = shuffsquare[gamerow][gamecol];
		          temp2 = shuffsquare[gamerow+1][gamecol];
		          shuffsquare[gamerow][gamecol] = temp2;
		          shuffsquare[gamerow+1][gamecol] = temp;
		        }catch(Exception e){
		          System.out.println("This is not a valid move.");
		        }
		      }
		      if(direction.equals("U")){
		        try{
		          temp = shuffsquare[gamerow][gamecol];
		          temp2 = shuffsquare[gamerow-1][gamecol];
		          shuffsquare[gamerow][gamecol] = temp2;
		          shuffsquare[gamerow-1][gamecol] = temp;
		        }catch(Exception e){
		          System.out.println("This is not a valid move.");
		        }
		      }
		      if(direction.equals("L")){
		        try{
		          temp = shuffsquare[gamerow][gamecol];
		          temp2 = shuffsquare[gamerow][gamecol-1];
		          shuffsquare[gamerow][gamecol] = temp2;
		          shuffsquare[gamerow][gamecol-1] = temp;
		        }catch(Exception e){
		          System.out.println("This is not a valid move.");
		        }
		      }
		      if(direction.equals("R")){
		        try{
		          temp = shuffsquare[gamerow][gamecol];
		          temp2 = shuffsquare[gamerow][gamecol+1];
		          shuffsquare[gamerow][gamecol] = temp2;
		          shuffsquare[gamerow][gamecol+1] = temp;
		        }catch(Exception e){
		          System.out.println("This is not a valid move.");
		        }
		      }
		      exact = 0;
		      for(int q = 0; q < num; q++){
		        for(int w = 0; w < num; w++){
		          if(shuffsquare[q][w] == square[q][w]){
		            exact++;
		          }
		        }
		      }
		      if(exact == num * num){
		        equals = true;
		      }
		    }

		    System.out.println("Congratulations! It took you " + turns + " turns to finish the game.");
		  }

		}
