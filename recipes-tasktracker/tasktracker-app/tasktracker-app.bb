DESCRIPTION = "Tasktracker UI application"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYING;md5=0b517682c7617713822d978dd663ea09"
PATCHTOOL = "git"
SRC_URI = "gitsm://github.com/salmmike/tasktracker.git;branch=master;protocol=https;"
SRCREV = "bdd8da2be256937d9c69b19d8497e2910d349625"

SRC_URI:append = " file://001-remove-clang-tidy.patch "

S = "${WORKDIR}/git"

DEPENDS += " qtbase \
             qtdeclarative \
             qtdeclarative-native \
             qtquick3d \
             qthttpserver \
             sqlite3 \
             fmt "

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "start-tasktracker.service"

SRC_URI:append = " file://start-tasktracker.service "
FILES_${PN} += "${systemd_unitdir}/system/start-tasktracker.service"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/start-tasktracker.service ${D}/${systemd_unitdir}/system
}

inherit pkgconfig cmake qt6-cmake systemd
