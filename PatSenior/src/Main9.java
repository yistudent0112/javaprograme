import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main9 {
 
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] fs = reader.readLine().split(" ");
        int pn = Integer.valueOf(fs[0]), qn = Integer.valueOf(fs[1]), n = Integer.valueOf(fs[2]);
        PatJudge[] pj = new PatJudge[10010];
        int[] question = new int[qn];
        String[] qs = reader.readLine().split(" ");
        for(int i = 0; i < qn; i++)question[i] = Integer.valueOf(qs[i]);
        String[] str = null;
        int id;
        int pid;
        int grade;
        for(int i = 0; i < 10010; i++)
            pj[i] = new PatJudge(i, qn);
        for(int i = 0; i < n; i++)
        {
            str = reader.readLine().split(" ");
            id = Integer.valueOf(str[0]);
            pid = Integer.valueOf(str[1]);
            grade = Integer.valueOf(str[2]);
            if(grade != -1)pj[id].isUsed=1;
            if(grade == -1 && pj[id].grade[pid - 1] == -1)
            {
                pj[id].grade[pid - 1] = 0;
            }
            if(grade == question[pid - 1] && pj[id].grade[pid - 1] < grade)
            {
                ++pj[id].perfect;
            }
            if(pj[id].grade[pid - 1] < grade)
            {
                pj[id].grade[pid - 1] = grade;
            }
        }
        for(int i = 1; i < 10010; i++)
        {
            for(int j = 0; j < qn; j++)
            {
                if(pj[i].grade[j] > 0)
                    pj[i].sum += pj[i].grade[j];
            }
        }
        Arrays.sort(pj);
        int r = 1;
        for(int i = 0; i < 10010 && pj[i].isUsed > 0; i++)
        {
            if(i > 0 && pj[i].sum != pj[i - 1].sum)
            {
                r = i + 1;
            }
            System.out.print(String.format("%d %05d %d", r, pj[i].id, pj[i].sum));
            for(int j = 0; j < qn; j++)
            {
                if(pj[i].grade[j] == -1)
                    System.out.print(" -");
                else
                    System.out.print(" "+pj[i].grade[j]);
            }
            System.out.println();
        }
    }
}
 
class PatJudge implements Comparable<PatJudge>
{
    int id;
    int gnum;
    int[] grade;
    int sum;
    int perfect;
    int isUsed;
     
    public PatJudge(int id, int gnum)
    {
        isUsed = 0;
        perfect = 0;
        sum = 0;
        this.id = id;
        this.gnum = gnum;
        grade = new int[gnum];
        Arrays.fill(grade, -1);
    }
     
    @Override
    public int compareTo(PatJudge o) {
        if(isUsed != o.isUsed)return o.isUsed - isUsed;
        else if(sum != o.sum)return o.sum - sum;
        else if(perfect != o.perfect)return o.perfect - perfect;
        else return id - o.id;
    }
}