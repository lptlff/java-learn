import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Collect {

    private List list = new ArrayList();
    //define base information
    private final static String fileaddress = "C:\\Users\\lvlai\\Desktop\\java 学习\\collect.txt";
    private String username = "Tining";
    private String type = "web";
    private String output;
    private Map<String,Integer> dic;
    public Collect() {
    }
    public void collect(String web) throws IOException {
        this.read();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date_now = dateFormat.format(date);
        String address = web.split(" ")[1];
        String name = address.split("\\.")[0];
        int num = this.list.size();
        String str = String.valueOf(num+1)+"\t"+username+"\t"+type+"\t"+
                    name+"\t"+address+"\t"+date_now+"\t"+date_now+"\n";
        this.output = str;
        if (search(name) == false)
        {
            this.write();
        }

    }
    public void read() throws IOException {
        List list = new ArrayList();
        File file = new File(fileaddress);
        Map<String,Integer> dic = new HashMap<>();
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(fileaddress));
        String line;
        int line_num = 1;
        while((line = reader.readLine())!=null){
            //按\t分
            String key = line.split("\t")[3];
            dic.put(key,line_num);
            list.add(key);
        }
        this.dic = dic;
        this.list = list;
    }
    private boolean search(String s)
    {
        boolean isexist = false;
        if(this.dic.containsKey(s))
        {
            isexist = true;
            System.out.println("已存在");
        }

        return isexist;
    }
    public void write() throws IOException {
        File f=new File(fileaddress);
        FileWriter fw;
        fw=new FileWriter(f,true);
        fw.write(this.output);
        fw.close();
    }
}
