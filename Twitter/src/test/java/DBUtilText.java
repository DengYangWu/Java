import com.twitter.pojo.Admins;
import com.twitter.util.DBUtil;
import org.junit.Test;

import javax.swing.tree.RowMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class DBUtilText {
    public static void main(String[] args){

//        boolean result = false;
//        Admins admins=new Admins();
//        Scanner sc = new Scanner(System.in);
//        DBUtil dbUtil=new DBUtil();
//        System.out.println("请输入用户名：");
//        String aname= sc.nextLine();
//        System.out.println("请输入密码：");
//        String apwd = sc.nextLine();
//        String sql = "insert into adlogin(aid, aditime,adotime) values(?,?,?)";
//        int n = DBUtil.update(sql, 1, "2019-05-22", "2019-05-22");
        String sql = "insert into admins(aname,apwd,atime,astate,apower)values(?,?,?,?,?)";
        int n = DBUtil.update(sql, "admin1", "123", "2019-05-22",2,2);
        //Object obj[]=new Object[]{admins.getAid(),admins.getAname(),admins.getApwd(),admins.getAtime(),admins.getAstate(),admins.getApower()};




    }

}
