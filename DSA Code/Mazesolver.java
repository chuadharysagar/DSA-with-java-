import java.util.ArrayList;

public class Mazesolver {

    //count the number of the path 
public int countPath(int r, int c){
        if(r==1|| c==1){
            return 1;
        }

      int left = countPath(r, c-1);
      int right= countPath(r-1, c);
      return left+right;
    }


    // print all the path of the maze
    public void printPath(String p, int r, int c){
            if(r==1 && c==1){
                System.out.println(p);
                return ;
            }
            

            // for the diagonal
            if(r>1 && c>1){
                printPath(p+'K', r-1, c-1);
            }
            if(r>1){
            printPath(p+'D', r-1, c);
            }

            if(c>1){
            printPath(p+'R', r, c-1);
            }

    }

    //return the list of the all the path including the diagonal path
    public ArrayList<String> PathList(String p , int r, int c){
              if(r==1 && c==1){
                ArrayList<String> ans= new ArrayList<>();
                ans.add(p);
                return ans;
              }
              
            ArrayList<String> list= new ArrayList<>();
            
            if(r>1 && c>1){
            list.addAll(PathList(p+'D', r-1, c-1));
            }

            if(r>1){
            list.addAll(PathList(p+'V', r-1, c));
            }

            if(c>1){
            list.addAll(PathList(p+'H',r, c-1));
            }
        return list;
    }

    //maze solver with obstacles 
    public void pathwithObstacle(String p, int r, int c,boolean [] [] maze){
            if(r==maze.length-1 && c== maze[0].length-1){
                System.out.println(p);
                return;
            }

            if(maze[r][c]==false){
                return;
            }

            if(c<maze.length-1){
                pathwithObstacle(p+'R', r, c+1, maze);
            }

            if(r<maze[0].length-1){
                pathwithObstacle(p+'D', r+1, c, maze);
            }

    }

public static void main(String[] args) {
    Mazesolver ms = new Mazesolver();
    
    System.out.println(ms.countPath(3, 3));
    // ms.printPath("", 3, 3);

    // ArrayList<String> result= ms.PathList("", 3, 3);
    // System.out.println(result);

    boolean[][]maze={
        {true,true,true},
        {true,true,true},
        {false,true,true}
    };

    ms.pathwithObstacle("",0,0,maze);

}    
}
