SUMMARY = "Tasktrakcer linux image"

inherit core-image

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs weston "

CORE_IMAGE_EXTRA_INSTALL += "wayland weston "
IMAGE_INSTALL:append = " tasktracker-app lshw libinput qtlocation-plugins qtlocation-qmlplugins qtwayland "
MACHINE_FEATURES:append = " wifi "

LICENSE = "MIT"

QB_MEM = "-m 512"

