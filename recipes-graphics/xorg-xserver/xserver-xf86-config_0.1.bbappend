FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
# Don't forget to bump PRINC if you update the extra files.
PRINC = "3"

SRC_URI_append_openpandora = " file://xorg.conf.d/10-evdev.conf \
                                 file://xorg.conf.d/20-omapfb.conf \
                                 file://xorg.conf.d/99-calibration.conf \
"

CONFFILES_${PN}_append_openpandora = "\
                    ${sysconfdir}/X11/xorg.conf.d/10-evdev.conf \
                    ${sysconfdir}/X11/xorg.conf.d/20-omapfb.conf \
                    ${sysconfdir}/X11/xorg.conf.d/99-calibration.conf \
"

do_install_append_openpandora () {
        install -d ${D}/${sysconfdir}/X11/xorg.conf.d/
        install -m 0644 ${WORKDIR}/xorg.conf.d/* ${D}/${sysconfdir}/X11/xorg.conf.d/
}

FILES_${PN} += "${sysconfdir}/X11/xorg.conf.d"
