import java.util.*;

public class Backtracking {
            static void  FindAllPath(String p,int r,int c,boolean[][]maze){
                if(r==maze.length-1 && c==maze.length-1){
                    System.out.println(p);
                    return ;
                }
               
                // if you have alrady visited the cell or the marked then don't visit it again
                if(maze[r][c]==false){
                    return;
                }
                
                //marking the cell which are visited
                maze[r][c]=false;
                
                //moving down
                if(r<maze.length-1){
                    FindAllPath(p+"D", r+1, c, maze);
                }
               
                // Moving to the right
                if(c<maze[0].length-1){
                    FindAllPath(p+"R", r, c+1, maze);
                }
                
                //moving up
                if(r>0){
                    FindAllPath(p+"U", r-1, c, maze);
                }

                //moving left side
                if(c>0){
                    FindAllPath(p+"L", r, c-1, maze);
                }

                // for the another recursion call setting the values to the normal so that it cound frrly make recursion call
                maze[r][c]=true;
            }


            static void PrintAllPAth(int count,int r,int c,int[][]maze){
                if(r==maze.length-1 && c==maze.length-1){
                    maze[r][c]=count;
                    for(int [] arr:maze){
                        System.out.println(Arrays.toString(arr));
                    }
                    System.out.println();
                    return ;
                }
               
                // if you have alrady visited the cell or the marked then don't visit it again
                if(maze[r][c]!=0){
                    return;
                }
                
                //marking the cell which are visited
                maze[r][c]=count;
                
                //moving down
                if(r<maze.length-1){
                    PrintAllPAth(count+1, r+1, c, maze);
                }
               
                // Moving to the right
                if(c<maze[0].length-1){
                    PrintAllPAth(count+1, r, c+1, maze);
                }
                
                //moving up
                if(r>0){
                    PrintAllPAth(count+1, r-1, c, maze);
                }

                //moving left side
                if(c>0){
                    PrintAllPAth(count+1, r, c-1, maze);
                }

                // for the another recursion call setting the values to the normal so that it cound frrly make recursion call
                maze[r][c]=0;
            }

    public static void main(String[] args) {
        //let's assume in this question we can go in any of the direction 
        // destination is last corner element index=(2,2)

        boolean[][]maze={
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        
        int [][] matrix={
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        FindAllPath("", 0, 0, maze);
        PrintAllPAth(1, 0, 0, matrix);


    }
    
}
