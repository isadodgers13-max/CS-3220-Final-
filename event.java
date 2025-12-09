@Entity
@Table(name="event")
public class Event {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(nullable=false)
  private String name;
]
