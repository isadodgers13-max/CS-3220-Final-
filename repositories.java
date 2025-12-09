public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);
  List<Employee> findAllByOrderByLastNameAscFirstNameAsc();
}

public interface EventRepository extends JpaRepository<Event, Long> {
  List<Event> findAllByOrderByIdAsc();
}

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
  Optional<Attendance> findByEmployeeIdAndEventId(Long empId, Long eventId);
  List<Attendance> findByEvent(Event event);
  List<Attendance> findByEmployee(Employee employee);
}
