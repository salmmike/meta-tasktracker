SUMMARY = "Tasktrakcer linux image"

inherit core-image

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs weston "

CORE_IMAGE_EXTRA_INSTALL += "wayland weston weston-xwayland "
CORE_IMAGE_BASE_INSTALL += " weston-xwayland "

LICENSE = "MIT"

QB_MEM = "-m 512"

