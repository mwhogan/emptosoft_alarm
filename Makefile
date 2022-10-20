SRC_FILES := $(wildcard alarm/*)

build: $(SRC_FILES)
	javac -d build alarm/*.java
	cp alarm/*.wav build/alarm/

Alarm.jar: build
	(cd build; jar cef alarm.Alarm ../Alarm.jar *)

run: Alarm.jar
	java -jar Alarm.jar

clean:
	rm -rf build
	rm -f Alarm.jar
