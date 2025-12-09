@GetMapping("/attendance/record")
public String recordAttendance(@RequestParam Long emp, @RequestParam Long ev, @RequestParam Boolean val, RedirectAttributes ra) {
  Employee employee = employeeRepo.findById(emp).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  Event event = eventRepo.findById(ev).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

  Attendance att = attendanceRepo.findByEmployeeIdAndEventId(emp, ev)
                   .orElseGet(() -> {
                     Attendance newAtt = new Attendance();
                     newAtt.setEmployee(employee);
                     newAtt.setEvent(event);
                     return newAtt;
                   });
  att.setAttended(val);
  attendanceRepo.save(att);

  return "redirect:/";
}
