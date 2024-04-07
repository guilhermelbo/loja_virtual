package lojavirtual.loja_virtual.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "product_brand")
@SequenceGenerator(name = "seq_product_brand", sequenceName = "seq_product_brand", allocationSize = 1, initialValue = 1)
public class ProductBrand implements Serializable {
    public ProductBrand(@Nonnull String descriptionName) {
        setDescriptionName(descriptionName);
    }

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_brand")
    private Long id;

    @Column(name = "description_name", nullable = false, length = 255)
    private String descriptionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        if (descriptionName == null) {
            throw new IllegalArgumentException("Description Name cannot be null");
        }
        if (descriptionName.length() > 255) {
            throw new IllegalArgumentException("Description Name cannot be longer than 255 characters");
        }
        this.descriptionName = descriptionName;
    }
}
