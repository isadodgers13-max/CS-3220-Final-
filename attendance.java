@Entity
@Table(name="attendance", uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id", "event_id"}))
public class Attdendance {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional=false)
  @JoinColumn(name="employee_id")
  private Employee employee;

  @ManyToOne(optional=false)
  @JoinColumn(name="event_id")
  private Event event;

  private Boolean attended;

}
