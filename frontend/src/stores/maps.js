import { defineStore } from 'pinia';

export const useMapsStore = defineStore('maps', {
  state: () => ({
    maps: [],
    currentMap: null,
  }),
  actions: {
    setMaps(maps) {
      this.maps = maps;
    },
    setCurrentMap(map) {
      this.currentMap = map;
    },
  },
});
