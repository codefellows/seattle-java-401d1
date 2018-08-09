#### Stopwatch
Create an stopwatch application. Have a button to `[Start/Pause]` and `[Reset]`
the clock. The start/pause button should toggle between saying "start" and
"pause." And you should only be able to reset when the stopwatch is paused.

Have the view update as fast as possible while still leaving the buttons
responsive.

Display the clock as `0:00:00.000` so it should be able to track up to
9 hours, 59 minutes, 59 seconds and 999 milliseconds.

You can use `System.currentTimeMillis()` to track the start and current time
at the millisecond-level.

```java
System.out.print("Current Time in milliseconds = ");
System.out.println(System.currentTimeMillis());
```

**Heads up:** You will learn something about Threads on Android. It will be
impossible to constantly be updating the time display and handle button clicks
on the same thread simultaneously.

`while (true) { }` loops are a bad idea.
