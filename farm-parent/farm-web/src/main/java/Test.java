/**
 * @author zhouye
 * @date 2022/7/25
 */
public class Test {
    public static void main(String[] args) {
        Integer e = 1;
        changeValue(2);
        System.out.println(e);
    }

    static void changeValue(Integer e) {
        e = Integer.valueOf(2);
    }
}
