package projekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class EquipmentTransaction {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pickup_schedule_id")
    private PickupSchedule pickupSchedule;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "equipment_set_id")
    private EquipmentSet equipmentSet;
}