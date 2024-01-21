SUMMARY = "Tasktrakcer linux image"

inherit core-image

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs weston "

CORE_IMAGE_EXTRA_INSTALL += "wayland weston weston-xwayland "
CORE_IMAGE_BASE_INSTALL += " weston-xwayland "
IMAGE_INSTALL:append = " tasktracker-app "

LICENSE = "MIT"

QB_MEM = "-m 512"

