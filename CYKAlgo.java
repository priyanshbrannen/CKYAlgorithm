
package cyk.algo;
import java.util.*;
/**
 *
 * @author Richie
 */
public class CYKAlgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
   String w[]= {"b","a","a","b","a"};
   String v[][]= new String[5][5];
   //Scanner s = new Scanner(System.in);
   //String[][] G = new String[10][];
  // System.out.println("Enter the Grammar :");
  
  String[][] g = {{"S","AB","BC"},{"A","BA","a"},{"B","CC","b"},{"C","AB","a"}};
  int n=w.length;
  for(int i=0;i<w.length;i++)
  {
      v[i][i]="";
      for(int j=0;j<g.length;j++)
      {
          for(int k=0;k<g[j].length;k++)
          {
              if(g[j][k].equals(w[i]))
              {
                  if(v[i][i].equals(""))
                       v[i][i]=v[i][i].concat(g[j][0]);
                  else
                      v[i][i]=v[i][i].concat(","+g[j][0]);
              }
          }
      }
  }
  
 int j;
 String[] f=new String[10];
 String[] s=new String[10];
  int flag1=0,flag2=0,iterate=0,flag=0;
  
  for(int len=2;len<n+1;++len)
  {  
      for(int i=0;i<n-len+1;i++)
      {
          j=i+len-1;
          v[i][j]="";           
          for(int k=i;k<j;++k)
          {
               f=v[i][k].split(",");
               flag1=v[i][k].split(",").length;                                        
               s=v[k+1][j].split(",");
               flag2=v[k+1][j].split(",").length;
          
          if(f[0].equals(""))
              flag1=0;
          if(s[0].equals(""))
              flag2=0;
          
          if(flag1!=0&&flag2!=0)                        //make comparisons only if there is any combination to be checked
                  {     
          String[] temp=new String[flag1*flag2]; 
            for(int nn=0,x=0;x<flag1;++x)
            {
               for(int y=0;y<flag2;++y,++nn)
               { 
                   if(flag1==1&&flag2!=1)
                          temp[nn]=v[i][k].concat(s[y]);
                   else if(flag1==1&&flag2==1)
                           temp[nn]=v[i][k].concat(v[k+1][j]);
                   else if(flag1!=1&&flag2!=1)
                           temp[nn]=f[x].concat(s[y]);
                   else if(flag1!=1&&flag2==1)
                           temp[nn]=f[x].concat(v[k+1][j]);  
               }
            }
           
              iterate=1;
            while(iterate<=temp.length) 
            {
              for(int l=0;l<g.length;l++)
              {  
                  String temp2[]=new String[v[i][j].length()];
                  temp2=v[i][j].split(",");
                for(int m=0;m<g[l].length;m++)
                {
                    flag=0;
                    
                    if(g[l][m].equals(temp[iterate-1]))
                    {
                            for(int a=0;a<temp2.length;++a)
                            {
                                if(temp2[a].equals(g[l][0]))
                                {
                                    flag=1;
                                    break;
                                }
                            }
                    }
                     
                    if(g[l][m].equals(temp[iterate-1])&&flag!=1)
                    {
                        if(v[i][j].equals(""))
                             v[i][j]=v[i][j].concat(g[l][0]);
                        else 
                            v[i][j]=v[i][j].concat(","+ g[l][0]);
                    }
                }
              }
              iterate++;
            }
                  }
         }                  // end of K loop
      }                     // end of I loop
  }                         // end of Len loop

  
 for(int l=0;l<5;l++)
   {
      for(int m=0;m<5;m++)
        { 
            //if(v[l][m].length()>1)
            System.out.print("{"+v[l][m]+"}");
        }
      System.out.println("");
   }
 f=v[0][4].split(",");
 flag=0;
 for(int a=0;a<v[0][4].length();++a)
 {
     if(f[a].equals("S"))
     {
                  flag=1;
                  break;
     }
 }
 if(flag==1)
     System.out.println("The string '"+Arrays.toString(w)+"'is accepted by the grammar");
 else
     System.out.println("The entered string '"+Arrays.toString(w)+"' is not accepted by the grammar");
  /*System.out.println("Enter the string : ");
  
   System.out.println("Enter the grammar : ");
    int i=0,j;
    System.out.println("Enter no. of productions : ");
    
    while(1){
        j=0;
        System.out.println("Enter production "+(i+1)+" : ");
        System.out.println("Enter left : ");
        G[i][j]=
        
    }
        */
    }
    
}
