import java.text.SimpleDateFormat;
import java.util.Date;

enum ShipmentStatus {InProcess, Shipped, Delivered}
enum ShipmentSpeed{OneDay, Express, Mail}
class Shipment {
    private String shipmentId;
    private String carrier;
    private ShipmentStatus shipmentStatus;
    private Date shippedDate;
    private Date deliveryDate;
    private ShipmentSpeed shipmentSpeed;

    public String getShipmentId() {
        return shipmentId;
    }

    public String getCarrier() {
        return carrier;
    }

    public ShipmentStatus getShipmentStatus() {
        return shipmentStatus;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public ShipmentSpeed getShipmentSpeed() {
        return shipmentSpeed;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setShipmentSpeed(ShipmentSpeed shipmentSpeed) {
        this.shipmentSpeed = shipmentSpeed;
    }

    @Override
    public String toString() {
        SimpleDateFormat neatly = new SimpleDateFormat("MMMM dd, yyyy");

        return "Shipment{" +
                "shipmentId='" + shipmentId + '\'' +
                ", carrier='" + carrier + '\'' +
                ", shipmentStatus=" + shipmentStatus +
                ", shippedDate=" + neatly.format(shippedDate) +
                ", deliveryDate=" + neatly.format(deliveryDate) +
                ", shipmentSpeed=" + shipmentSpeed +
                '}';
    }
}
