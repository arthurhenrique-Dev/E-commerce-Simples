package Domain.Entities.Products;

import Domain.ValueObjects.Quantity;
import Domain.ValueObjects.ValidText;

import java.util.List;

public class Product {

    private final Long id;
    private ValidText name;
    private ValidText description;
    private List<Model> models;
    private List<Review> reviews;
    private Quantity totalQuantity;
    private AvailabilityStatus availability;
    private Integer timesViewed;
    private Integer timesPurchased;

    private Quantity quantityTotal(List<Model> models) {
        Integer totalQuantity = 0;
        for (Model model : models) {
            totalQuantity += model.getQuantity().quantity();
        }
        return new Quantity(totalQuantity);
    }

    private Integer totalTimesViewed(List<Model> models) {
        Integer totalTimesViewed = 0;
        for (Model model : models) {
            totalTimesViewed += model.getTimesViewed();
        }
        return totalTimesViewed;
    }

    private Integer totalTimesPurchased(List<Model> models) {
        Integer totalTimesPurchased = 0;
        for (Model model : models) {
            totalTimesPurchased += model.getTimesPurchased();
        }
        return totalTimesPurchased;
    }

    private AvailabilityStatus checkAvailability() {
        return this.totalQuantity.quantity() > 0 ? AvailabilityStatus.IN_STOCK : AvailabilityStatus.OUT_OF_STOCK;
    }

//    private List<String> photosConfig(List<String> photos, Integer idx) {
//        if (idx != null) {
//            return this.models.get(idx).getPhotos();
//        } else {
//            if (!photos.isEmpty()) return photos;
//            if (!(this.models.stream().anyMatch(model -> model.getTimesPurchased() > 0))) {
//                return this.models.getFirst().getPhotos();
//            }
//            return this.models.stream()
//                    .max(Comparator.comparingInt(Model::getTimesPurchased))
//                    .map(Model::getPhotos)
//                    .orElseThrow(InvalidDataException::new);
//        }
//    }
//
//    private Price priceConfig(Price price, Integer idx) {
//
//    }

    public Product(Long id, ValidText name, ValidText description, List<Model> models, List<Review> reviews, List<String> photo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.models = models;
        this.reviews = reviews;
        this.timesViewed = totalTimesViewed(models);
        this.timesPurchased = totalTimesPurchased(models);
        this.totalQuantity = quantityTotal(models);
        this.availability = checkAvailability();
    }
}
