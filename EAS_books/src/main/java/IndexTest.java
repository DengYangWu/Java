import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import org.junit.Before;
import org.junit.Test;

public class IndexTest {
//    JSON_Gson json_gson;
//    @Before
//    public void prepare(){
//
//        json_gson = new JSON_Gson(1,"dyw",20,"321");
//    }
//
//    @Test
//    public void index(){
//        Gson gson=new Gson();
//        System.out.println(gson.toJson(json_gson));
//        System.out.println("-------------------------");
//        Gson gson1 = new GsonBuilder().create();
//        System.out.println(gson1.toJson(json_gson));
//    }
    @Test
    public void index(){
        Gson gson=new GsonBuilder().create();
        TypeAdapter<JSON_Gson> typeAdapter=gson.getAdapter(JSON_Gson.class);

    }
}
