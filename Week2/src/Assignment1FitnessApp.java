/*You are building a Fitness Tracker that tracks different workout types:
Running
Cycling
Swimming

Each workout:
must be validated
can calculate calories burned
shares some common behavior
 */
interface Workout {

    void performWorkout();

    String getWorkoutType();
}

// ===== ABSTRACT CLASS =====
abstract class AbstractWorkout implements Workout {

    protected String userName;
    protected int duration; // in minutes

    public AbstractWorkout(String userName, int duration) {
        this.userName = userName;
        this.duration = duration;
    }

    
    // TODO 1:
    // Create a concrete method logWorkout()
    // Print: <userName> completed a workout of <duration> minutes

    public void logWorkout(){
        System.out.println(userName + " completed a workout of " + duration + " minutes");
        System.out.println("--------------------");
    }

    // TODO 2:
    // Create an abstract method calculateCalories() that returns a double

    public abstract double calculateCalories();
}

// ===== CONCRETE CLASS 1 =====
class RunningWorkout extends AbstractWorkout {

    private double distance; // in km
    private double calories;

    public RunningWorkout(String userName, int duration, double distance) {
        super(userName, duration);
        this.distance = distance;
    }

    // TODO 3:
    // Implement calculateCalories()
    // Hint: calories = distance * 60

    @Override
    public double calculateCalories(){
        calories = distance * 60;
        return calories;
    }
    // TODO 4:
    // Implement performWorkout()
    // Steps:
    // 1. Print "Running session started..."
    // 2. Print value returned from calculateCalories()
    // 3. Call logWorkout()

    @Override
    public void performWorkout(){
        System.out.println("Running session started...");
        System.out.println("Calories burned: " + calculateCalories());
        logWorkout();
    }

    // TODO 5:
    // Implement getWorkoutType() → return "Running"

    @Override
    public String getWorkoutType(){
        return "Workout type: Running";
    }

}

// ===== CONCRETE CLASS 2 =====
class CyclingWorkout extends AbstractWorkout {

    private double speed; // km/h
    private double calories;

    public CyclingWorkout(String userName, int duration, double speed) {
        super(userName, duration);
        this.speed = speed;
    }

    // TODO 6:
    // Implement calculateCalories()
    // Hint: calories = speed * duration * 2

    @Override
    public double calculateCalories(){
        calories = speed * duration * 2;
        return calories;
    }

    // TODO 7:
    // Implement performWorkout()
    // Steps:
    // 1. Print "Cycling session started..."
    // 2. Print value returned from calculateCalories()
    // 3. Call logWorkout()

    @Override
    public void performWorkout(){
        System.out.println("Cycling session started...");
        System.out.println("Calories burned: " + calculateCalories());
        logWorkout();
    }

    // TODO 8:
    // Implement getWorkoutType() → return "Cycling"

    @Override
    public String getWorkoutType(){
        return "Workout type: Cycling";
    }
}

// ===== CONCRETE CLASS 3 =====
class SwimmingWorkout extends AbstractWorkout {

    private int laps;
    private double calories;

    public SwimmingWorkout(String userName, int duration, int laps) {
        super(userName, duration);
        this.laps = laps;
    }

    // TODO 9:
    // Implement calculateCalories()
    // Hint: calories = laps * 10

    @Override
    public double calculateCalories(){
        calories = laps * 10;
        return calories;
    }

    // TODO 10:
    // Implement performWorkout()
    // Steps:
    // 1. Print "Swimming session started..."
    // 2. Print value returned from calculateCalories()
    // 3. Call logWorkout()

    @Override
    public void performWorkout(){
        System.out.println("Swimming session started...");
        System.out.println("Calories burned: " + calculateCalories());
        logWorkout();
    }

    // TODO 11:
    // Implement getWorkoutType() → return "Swimming"

    @Override
    public String getWorkoutType(){
        return "Workout type: Swimming";
    }
}

// ===== UTILITY CLASS (OVERLOADING) =====
class FitnessUtils {

    // TODO 12:
    // Method logSummary(int totalMinutes)
    // Print: Total workout time: <totalMinutes> minutes

    public void logSummary(int totalMinutes){
        System.out.println("Total workout time: " + totalMinutes + " minutes");
    }

    // TODO 13:
    // Overloaded method logSummary(int totalMinutes, String level)
    // Print: Total workout time: <totalMinutes> minutes - Level: <level>

    public void logSummary(int totalMinutes, String level){
        System.out.println("Total workout time: " + totalMinutes + " minutes - Level: " + level);
    }
}

// ===== MAIN DRIVER =====
public class Assignment1FitnessApp {

    public static void main(String[] args) {

        // TODO 14:
        // Create objects for Running, Cycling, Swimming

        RunningWorkout run = new RunningWorkout("Alice", 30, 5);
        CyclingWorkout cycle = new CyclingWorkout("Bob", 45, 20);
        SwimmingWorkout swim = new SwimmingWorkout("Charlie", 25, 30);

        // TODO 15:
        // Store them in a Workout array

        Workout[] workouts = {run, cycle, swim};

        // TODO 16:
        // Loop through workouts:
        // 1. Print workout type
        // 2. Call performWorkout()
        // 3. Accumulate/sum the duration of all workouts
        int totalMinutes = 0;
        for (Workout workout : workouts) {
            System.out.println(workout.getWorkoutType());
            workout.performWorkout();
            totalMinutes += ((AbstractWorkout) workout).duration;
        }
        // TODO 17:
        // Create FitnessUtils object
        // Call both versions of logSummary()
        FitnessUtils utils = new FitnessUtils();
        utils.logSummary(totalMinutes);
        System.out.println(utils);
        utils.logSummary(totalMinutes, "Intermediate");
        System.out.println(utils);
    }
}
