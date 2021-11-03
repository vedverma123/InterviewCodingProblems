import org.apache.commons.lang.StringUtils;

public class StringContainsTest {

    public static void main(String[] args) {
        String uri = "/my-account/payment-details/hop/response";
        String requestURI = "/my-account/payment-details/hop/response/jasbhjdab----gnajsajn";
        String requestURI1 = "/my-account/payment-details";
        System.out.println(requestURI1.contains(uri));
    }

}
