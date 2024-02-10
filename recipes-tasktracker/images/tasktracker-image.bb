SUMMARY = "Tasktrakcer linux image"

inherit core-image

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs weston "

CORE_IMAGE_EXTRA_INSTALL += "wayland weston "

IMAGE_INSTALL:append = " tasktracker-app tasktracker-webui \
			 lshw libinput qtlocation-plugins \
			 qtlocation-qmlplugins qtwayland \
			 dhcpcd iw wpa-supplicant wireless-regdb-static \
			 hostapd wifi-ui-configurator "

MACHINE_FEATURES:append = " wifi "

LICENSE = "MIT"

QB_MEM = "-m 512"

