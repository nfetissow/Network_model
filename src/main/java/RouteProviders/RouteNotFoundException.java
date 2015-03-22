package RouteProviders;

/***
 * Exception thrown if RouteProviders was not able to find a route
 */
public class RouteNotFoundException extends Exception {
    private String msg;
    public RouteNotFoundException(String msg) {
        this.msg = msg;
    }
}
