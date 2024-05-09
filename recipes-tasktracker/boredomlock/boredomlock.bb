DESCRIPTION = "Boredomlock library"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYING;md5=0b517682c7617713822d978dd663ea09"
PATCHTOOL = "git"
SRC_URI = "gitsm://github.com/salmmike/boredom-lock.git;branch=master;protocol=https;"
SRCREV = "${AUTOREV}"

SRC_URI:append = " file://001-remove-tests.patch "

S = "${WORKDIR}/git"

DEPENDS += " libusb1 libusb "

inherit pkgconfig cmake
