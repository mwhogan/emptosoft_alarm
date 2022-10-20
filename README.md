# Emptosoft Alarm

This is a small utility that asks the user to enter a number of minutes, then waits for that number of minutes before playing an alarm sound and offering a 5 minute snooze option. It comes with a built-in alarm sound, but you can use your own alarm sound by placing an appropriate file named "sound.wav" in the directory from which you run this utility.

## Getting started

To run this utility, use:
```sh
make run
```
To customise the alarm sound, place an appropriate file named "sound.wav" in the same directory as the Makefile. To quickly test your customised alarm sound, you can set the alarm to sound in 0 minutes.

## Building

To build a redistributable Jar file, use:
```sh
make Alarm.jar
```
This will produce a file called "Alarm.jar".

## Change log

v1.0 (23/04/09):
- First version
- Very basic UI
- Ability to set an alarm to go off in any number of minutes
- Alarm sound included, but any sound or music can be used
- Snooze function has a fixed duration - 5 minutes

