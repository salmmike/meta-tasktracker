DESCRIPTION = "Tasktracker UI application"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYING;md5=0b517682c7617713822d978dd663ea09"
PATCHTOOL = "git"
SRC_URI = "gitsm://github.com/salmmike/tasktracker.git;branch=master;protocol=https;"
SRCREV = "${AUTOREV}"

SRC_URI:append = " file://001-remove-clang-tidy.patch "

S = "${WORKDIR}/git"

DEPENDS += " qtbase \
             qtdeclarative \
             qtdeclarative-native \
             qtwayland \
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

EXTRA_OECMAKE += "-DQT_FEATURE_egl=ON -DFEATURE_opengl=ON"

inherit pkgconfig cmake qt6-cmake systemd
