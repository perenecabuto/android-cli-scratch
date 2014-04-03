
update-project:
	android update project \
	--path . \
	--target "Google Inc.:Google APIs:17" \


create-project:
	android create project \
	--path . \
	--target "Google Inc.:Google APIs:17" \
	--name scratch \
	--package net.lukazupareli \
	--activity MainActivity

install-run:
	ant debug install && adb shell 'am start -n net.lukazupareli/.MainActivity'

build:
	ant debug

log:
	adb logcat

install-sdk:
	android update sdk -u
