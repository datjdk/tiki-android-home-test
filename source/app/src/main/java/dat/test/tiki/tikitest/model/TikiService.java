package dat.test.tiki.tikitest.model;

public class TikiService {
    private int serviceLogo;
    private String serviceName;

    public TikiService(int serviceLogo, String serviceName) {
        this.serviceLogo = serviceLogo;
        this.serviceName = serviceName;
    }

    public int getServiceLogo() {
        return serviceLogo;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceLogo(int serviceLogo) {
        this.serviceLogo = serviceLogo;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
