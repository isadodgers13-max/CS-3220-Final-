@Entity
@Table(name="employee", uniqueConstraints = @UniqueConstraint(columnNames = {"first_name","last_name"}))
public class Employee {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(name="first_name", nullable=false)
  private String firstName;
  @Column(name="last_name", nullable=false)
  private String lastName;
}
