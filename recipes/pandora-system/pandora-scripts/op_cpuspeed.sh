#!/bin/bash
#get value range
minmhz=100
safemhz=600
maxmhz=900 
curmhz=$(cat /proc/pandora/cpu_mhz_max)
device=/proc/pandora/cpu_mhz_max
if [ ! $1 ]; then
newmhz=$(DISPLAY=0:0 zenity --scale --text "set cpu mhz" --min-value=$minmhz --max-value=$maxmhz --value=$curmhz --step 1)
else
newmhz=$1
fi
if [ $newmhz ]; then
	if [ $newmhz -ge $safemhz ]; then
		answer=$(DISPLAY=0:0 zenity --question --title "Alert" --text "You are trying to set the cpu clock to $newmhz which is above its specification of $safemhz, doing so may burn down your house, sour milk, or just blow up (ok, not that likely)! proceed?";echo $?)
		echo $answer
		if [ $answer = 1 ]; then exit 1; fi
	fi
 
	if [ $newmhz -le $minmhz ]; then newmhz=$minmhz; fi
	if [ $newmhz -ge $maxmhz ]; then newmhz=$maxmhz; fi
fi
echo $newmhz > $device
echo cpu_mhz_max set to $(cat /proc/pandora/cpu_mhz_max)